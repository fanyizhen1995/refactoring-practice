package com.fyz.chapter006.before;

public class SplitTemporaryVariable {

    private double _primaryForce;
    private double _mass;
    private int _delay;
    private double _secondaryForce;

    public SplitTemporaryVariable(double _primaryForce, double _mass, int _delay, double _secondaryForce) {
        this._primaryForce = _primaryForce;
        this._mass = _mass;
        this._delay = _delay;
        this._secondaryForce = _secondaryForce;
    }

    double getDistanceTravelled (int time) {
        double result;
        double acc = _primaryForce / _mass;
        int primaryTime = Math.min(time, _delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - _delay;
        if (secondaryTime > 0) {
            double primaryVel = acc * _delay;
            acc = (_primaryForce + _secondaryForce) / _mass;
            result += primaryVel * secondaryTime + 0.5 * acc *
                    secondaryTime * secondaryTime;
        }
        return result;
    }

    public static void main(String[] args) {
        SplitTemporaryVariable s1 = new SplitTemporaryVariable(10,10,2,1);

        System.out.println("s1: " + s1.getDistanceTravelled(10));
    }
}
