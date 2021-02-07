package com.fyz.chapter004;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MasterTester extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite result = new TestSuite();
        result.addTest(new TestSuite(FileReaderTester.class));

        return result;
    }
}
