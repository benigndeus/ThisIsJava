package sec03.exam04_convert_buffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ByteBufferToStringExample {
    public static void main(String[] args) {
        Charset charset = Charset.forName("UTF-8");

        // String -> Encoding -> ByteBuffer
        String data = "안녕하세요";
        ByteBuffer byteBuffer = charset.encode(data);

        // ByteBufer -> Decoding -> CharBuffer -> String
        data = charset.decode(byteBuffer).toString();
        System.out.println("문자열 복원: " + data);
    }
}
