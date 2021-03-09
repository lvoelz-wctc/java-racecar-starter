package edu.wctc.racecar;

import javafx.application.Platform;

public class AnimateCarTask implements Runnable {

    public Car car;

    public AnimateCarTask(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        Runnable task = new AnimateCarTask(car);
        Thread thread = new Thread(task);
        thread.start();

        while (!Thread.currentThread().isInterrupted()){
            try {
                Platform.runLater(() -> car.move()); // Updates the X position of the car on screen
                /**This seems to freeze after a few moments**/
                //Thread.sleep(25-car.getSpeed());


                /**2500ms seems to work better than 25?**/
                Thread.sleep(2500-car.getSpeed());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
