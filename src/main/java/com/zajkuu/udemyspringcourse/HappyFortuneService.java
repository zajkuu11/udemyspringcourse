package com.zajkuu.udemyspringcourse;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "It's your lucky day!";
    }
}
