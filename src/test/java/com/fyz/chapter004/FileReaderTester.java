package com.fyz.chapter004;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.io.*;

public class FileReaderTester extends TestCase {

    private FileReader _input;
    private FileReader _empty;
    public FileReaderTester (String name) {
        super(name);
    }

    protected void setUp() {
        try {
            _input = new FileReader("src/main/java/com/fyz/chapter004/fixture.txt");
            _empty = newEmptyFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("unable to open test file");
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    private FileReader newEmptyFile() throws IOException {
        File empty = new File("empty.txt");
        FileOutputStream out = new FileOutputStream(empty);
        out.close();
        return new FileReader(empty);
    }

    protected void tearDown() {
        try {
            _input.close();
        } catch (IOException e) {
            throw new RuntimeException("error on closing test file");
        }
    }

    public void testRead() throws IOException {
        char ch = '&';

        //捕捉错误
        //_input.close();
        for (int i = 0; i < 4; i++) {
            ch = (char) _input.read();
        }
        //assert ('d' == ch);
        assertEquals('d', ch);
    }

    public void testReadAtEnd() throws IOException {
        int ch = -1234;
        for (int i = 0; i < 141; i++) {
            ch = (char) _input.read();
        }
        assertEquals(-1, _input.read());
    }

    public void testReadBoundaries() throws IOException {
        assertEquals("read first char", 'B', _input.read());
        int ch;
        for (int i = 0; i < 139; i++) {
            ch = (char) _input.read();

        }
        assertEquals("read last char", '6', _input.read());
        assertEquals("read at end", -1, _input.read());
        assertEquals("read past end", -1, _input.read());
    }

    public void testReadAfterClose() throws IOException {
        _input.close();
        try {
            _input.read();
            fail("no exception for read past end");
        } catch (IOException e) {

        }
    }
    public void testEmptyRead() throws IOException {

        assertEquals(-1, _empty.read());
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new FileReaderTester("testRead"));
        suite.addTest(new FileReaderTester("testReadAtEnd"));
        return  suite;
    }

    public static void main(String[] args) {
        //junit.textui.TestRunner.run(suite());
        junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
    }
}
