package com.inayath.multithreading;

import java.util.ArrayList;
import java.util.List;

public class MultExecutorClient {

    public static void main(String[] args) {
        List<Runnable> ls=new ArrayList<>();
        ls.add(()-> System.out.println("I am doing task1"));
        ls.add(()-> System.out.println("I am doing task2"));
        ls.add(()-> System.out.println("I am doing task3"));

        MultiExecutor me=new MultiExecutor(ls);
        me.executeAll();
    }


    private static class MultiExecutor{

        // Add any necessary member variables here
        List<Runnable> tasks;

        /*
         * @param tasks to executed concurrently
         */
        public MultiExecutor(List<Runnable> tasks) {
            // Complete your code here
            this.tasks=tasks;
        }

        /**
         * Starts and executes all the tasks concurrently
         */
        public void executeAll() {
            // complete your code here
            tasks.forEach(task->{
               new Thread(task).start();
            });
        }

    }
}
