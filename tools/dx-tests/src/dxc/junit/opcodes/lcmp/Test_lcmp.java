/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dxc.junit.opcodes.lcmp;

import dxc.junit.DxTestCase;
import dxc.junit.DxUtil;
import dxc.junit.opcodes.lcmp.jm.T_lcmp_1;

public class Test_lcmp extends DxTestCase {

    /**
     * @title  Arguments = 111234567891l > 111234567890l
     */
    public void testN1() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(1, t.run(111234567891l, 111234567890l));
    }

    /**
     * @title  Arguments = 112234567890 == 112234567890
     */
    public void testN2() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(0, t.run(112234567890l, 112234567890l));
    }

    /**
     * @title  Arguments = 112234567890 < 998876543210
     */
    public void testN3() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(-1, t.run(112234567890l, 998876543210l));
    }

    /**
     * @title  Arguments = Long.MAX_VALUE > Long.MIN_VALUE
     */
    public void testB1() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(1, t.run(Long.MAX_VALUE, Long.MIN_VALUE));
    }

    /**
     * @title  Arguments = Long.MIN_VALUE < Long.MAX_VALUE
     */
    public void testB2() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(-1, t.run(Long.MIN_VALUE, Long.MAX_VALUE));
    }

    /**
     * @title  Arguments = 1 > 0
     */
    public void testB3() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(1, t.run(1l, 0l));
    }

    /**
     * @title  Arguments = 0 > -1
     */
    public void testB4() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(1, t.run(0l, -1l));
    }

    /**
     * @title  Arguments = -1 < 0
     */
    public void testB5() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(-1, t.run(-1l, 0l));
    }

    /**
     * @title  Arguments = 0 = 0
     */
    public void testB6() {
        T_lcmp_1 t = new T_lcmp_1();
        assertEquals(0, t.run(0l, 0l));
    }

    /**
     * @constraint 4.8.2.1
     * @title number of arguments
     */
    public void testVFE1() {
        try {
            Class.forName("dxc.junit.opcodes.lcmp.jm.T_lcmp_2");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint 4.8.2.1
     * @title types of arguments - long, double
     */
    public void testVFE2() {
        try {
            Class.forName("dxc.junit.opcodes.lcmp.jm.T_lcmp_3");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint 4.8.2.1
     * @title types of arguments - float, long
     */
    public void testVFE3() {
        try {
            Class.forName("dxc.junit.opcodes.lcmp.jm.T_lcmp_4");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint 4.8.2.1
     * @title types of arguments - int, long
     */
    public void testVFE4() {
        try {
            Class.forName("dxc.junit.opcodes.lcmp.jm.T_lcmp_5");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

    /**
     * @constraint 4.8.2.1
     * @title types of arguments - reference, long
     */
    public void testVFE5() {
        try {
            Class.forName("dxc.junit.opcodes.lcmp.jm.T_lcmp_6");
            fail("expected a verification exception");
        } catch (Throwable t) {
            DxUtil.checkVerifyException(t);
        }
    }

}
