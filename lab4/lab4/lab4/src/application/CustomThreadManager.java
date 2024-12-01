package application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class CustomThreadManager {
    private final ObservableList<CustomThread> threadData;
    private final TableView<CustomThread> threadsTable;
    private final Playfield playfield;

    public CustomThreadManager(TableView<CustomThread> threadsTable, Playfield playfield) {
        this.threadData = FXCollections.observableArrayList();
        this.threadsTable = threadsTable;
        this.playfield = playfield;
        this.threadsTable.setItems(threadData);
    }

    public void addThreadResult(ThreadResult result) {
        CustomThread threadInfo = new CustomThread(
                result.getId(),
                result.getThreadName(),
                result.getUpdatedCell(),
                result.getExecutionTime(),
                "Completed"
        );

        Platform.runLater(() -> {
            threadData.add(threadInfo);

            String[] coordinates = result.getUpdatedCell().split("-");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            synchronized (playfield) {
                playfield.get(x,y).setValue(String.valueOf(
                        Integer.parseInt(playfield.get(x,y).getValue()) + 1
                ));
            }
        });
    }
}

