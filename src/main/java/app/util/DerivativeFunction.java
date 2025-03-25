package app.util;

@FunctionalInterface
public interface DerivativeFunction {
    vector3 apply(vector3 state, double time);
}