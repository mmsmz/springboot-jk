package com.springboot_crud.customerData.service;


class A {
    public static void main(String args[]) {

        int dayOfWeek = 3;

        String dataType = switch (dayOfWeek) {
            case 1, 7 -> "Weekend";
            case 2, 3, 4, 5, 6 -> "Weekday";
            default -> throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
        };
        System.out.println(dataType); // Output: Weekday
    }
}