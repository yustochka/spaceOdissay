package app.util;

public class vector3 {

    private double x;
    private double y;
    private double z;

    public vector3() {
        this(0, 0, 0);
    }

    public vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    // setters
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }

    // clone vector method
    public vector3 clone()
    {
        return new vector3(this.x, this.y, this.z);
    }

    // vector operations (+, -, *, /, length, normalize, dot)
    public vector3 add(vector3 other)
    {
        return new vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public vector3 subtract(vector3 other)
    {
        return new vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public vector3 scale(double factor)
    {
        return new vector3(this.x * factor, this.y * factor, this.z * factor);
    }

    public vector3 divideBy(double divisor)
    {
        return new vector3(this.x / divisor, this.y / divisor, this.z / divisor);
    }

    public double getLength()
    {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public vector3 normalize()
    {
        double length = getLength();
        return (length == 0) ? new vector3(0, 0, 0) : this.scale(1.0 / length);
    }

    public double dot(vector3 other)
    {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}