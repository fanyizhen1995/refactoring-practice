package com.fyz.chapter007.before;

public class ExtractClass {

    Person person = new Person("fyz", "A101", "12345");

    class Person {

        public Person(String _name, String _officeAreaCode, String _officeNumber) {
            this._name = _name;
            this._officeAreaCode = _officeAreaCode;
            this._officeNumber = _officeNumber;
        }

        public String getName() {
            return _name;
        }
        public String getTelephoneNumber() {
            return ("(" + _officeAreaCode + ") " + _officeNumber);
        }
        String getOfficeAreaCode() {
            return _officeAreaCode;
        }
        void setOfficeAreaCode(String arg) {
            _officeAreaCode = arg;
        }
        String getOfficeNumber() {
            return _officeNumber;
        }
        void setOfficeNumber(String arg) {
            _officeNumber = arg;
        }
        private String _name;
        private String _officeAreaCode;
        private String _officeNumber;
    }

    public static void main(String[] args) {
        ExtractClass ec = new ExtractClass();
        System.out.println(ec.person.getName() + ec.person.getTelephoneNumber());
    }

}
