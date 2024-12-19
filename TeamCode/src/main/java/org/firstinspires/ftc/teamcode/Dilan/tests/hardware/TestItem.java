package org.firstinspires.ftc.teamcode.Dilan.tests.hardware;

import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;

abstract public class TestItem {
    private final String description, title;

    protected TestItem(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    abstract public void run(boolean on, boolean other, TelemetrySynchronizer telemetrySynchronizer);
}
