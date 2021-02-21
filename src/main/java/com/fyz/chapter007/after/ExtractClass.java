package com.fyz.chapter007.after;

public class ExtractClass {

    Person person = new Person("fyz", "A101", "12345");

    class Person {

        private TelephoneNumber _officeTelephone = new TelephoneNumber();

        public Person(String _name, String _officeAreaCode, String _officeNumber) {
            this._name = _name;
            setOfficeAreaCode(_officeAreaCode);
            setOfficeNumber(_officeNumber);
        }

        public String getName() {
            return _name;
        }
        public String getTelephoneNumber() {
            return ("(" + getOfficeAreaCode() + ") " + getOfficeNumber());
        }
        String getOfficeAreaCode() {
            return _officeTelephone.get_areaCode();
        }
        void setOfficeAreaCode(String arg) {
            _officeTelephone.set_areaCode(arg);
        }
        String getOfficeNumber() {
            return _officeTelephone.get_number();
        }
        void setOfficeNumber(String arg) {
            _officeTelephone.set_number(arg);
        }
        private String _name;
    }

    class TelephoneNumber {
        private String _areaCode;
        private String _number;

        public String get_areaCode() {
            return _areaCode;
        }

        public void set_areaCode(String _areaCode) {
            this._areaCode = _areaCode;
        }

        public String get_number() {
            return _number;
        }

        public void set_number(String _number) {
            this._number = _number;
        }
    }

    public static void main(String[] args) {
        ExtractClass ec = new ExtractClass();
        System.out.println(ec.person.getName() + ec.person.getTelephoneNumber());
    }

}
