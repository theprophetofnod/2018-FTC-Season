/*
Copyright (c) 2017 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import android.support.annotation.Nullable;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;

/**
 * Instances of {@link RelicRecoveryVuMark} represent the VuMarks used in the Relic Recovery
 * FTC competition of 2017-18.
 */
@SuppressWarnings("WeakerAccess")
public enum ObjectMark
{
    UNKNOWN,
    LEFT,
    CENTER,
    RIGHT;

    public static ObjectMark from(@Nullable VuforiaTrackable trackable)
    {
        if (trackable != null)
        {
            return from(trackable.getListener());
        }
        return UNKNOWN;
    }

    public static ObjectMark from(@Nullable VuforiaTrackable.Listener listener)
    {
        if (listener instanceof VuforiaTrackableDefaultListener)
        {
            return from(((VuforiaTrackableDefaultListener)listener).getVuMarkInstanceId());
        }
        return UNKNOWN;
    }

    public static ObjectMark from(@Nullable VuMarkInstanceId instanceId)
    {
        ObjectMark result = UNKNOWN;
        if (instanceId != null && instanceId.getType()==VuMarkInstanceId.Type.NUMERIC)
        {
            long value = instanceId.getNumericValue();
            if (value==1)
            {
                result = LEFT;
            }
            else if (value==2)
            {
                result = CENTER;
            }
            else if (value==3)
            {
                result = RIGHT;
            }
        }
        return result;
    }
}
