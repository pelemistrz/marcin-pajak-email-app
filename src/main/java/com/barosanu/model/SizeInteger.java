package com.barosanu.model;

public class SizeInteger implements Comparable<SizeInteger> {
    private final int size;

    public SizeInteger(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        if(size<=0){
            return "0";
        }else if(size<1024){
            return size+" B";
        } else if(size<1024*1024){
            return size/1024+" kB";
        } else if(size<1024*1024*1024){
            return size/1024/1024+" mB";
        }
        return size/1024/1024/1024+" gB";
    }

    @Override
    public int compareTo(SizeInteger o) {
        if(size>o.size){
            return 1;
        }else if(size<o.size){
            return -1;
        }else {
            return 0;
        }

    }
}
