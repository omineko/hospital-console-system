package views;

public class Enums {
    public static enum Sex {
        MALE,
        FEMALE
    }

    public static enum Department {
        PEDIATRICS,
        SURGERY,
        ORTHOPEDICS,
        ANESTHESIOLOGY,
        DENTAL,
        EMERGENCY,
        INTERNAL
    }

    public static enum BloodType {
        APositive("A+"),
        ANegative("A-"),
        BPositive("B+"),
        BNegative("B-"),
        ABPositive("AB+"),
        ABNegative("AB-"),
        OPositive("O+"),
        ONegative("O-");

        private String value;
        private BloodType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

    }
}