package com.inayath.solid;


class Rectangle {

    int height;
    int width;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int area(){
        return this.height*this.width;
    }

}

class Square extends  Rectangle{

    public void setHeight(int height) {
        this.height = height;
        this.width=height;
    }

    public void setWidth(int width) {
        this.width = width;
        this.height=width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }



}

public class LSKViolates {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);

        Rectangle square = new Square();
        square.setWidth(5);

        printArea(rectangle);
        printArea(square);

    }

    static void printArea(Rectangle rectangle){
        System.out.println(rectangle.area());
    }
}
