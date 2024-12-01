package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class SampleController implements Initializable {
	
	@FXML
	private Pane matrix_panel;
	
	@FXML
	private TableView<CustomThread> threads_table;
	
	@FXML
	private Slider processesSlider;
	
	@FXML
	private TableColumn<CustomThread, Integer> id;
	
	@FXML
	private TableColumn<CustomThread, String> name;
	
	@FXML
	private TableColumn<CustomThread, String> returnedResult;
	
	@FXML
	private TableColumn<CustomThread, String> timeSpent;
	
	@FXML
	private TableColumn<CustomThread, String> status;
	
	@FXML
	private Text elapsedTime;
	
	private int size = 14;
	Playfield playfield = new Playfield(size);
	ThreadPoolExecutor pool;
	
	private Logger logger = new Logger();
	
	public void fill(ActionEvent e) {
		
        for( int i = 0; i < size; i++) {
            for( int j = 0; j < size; j++) {
                MatrixNode node = new MatrixNode( "0", i * size, j * size, size, size);
                matrix_panel.getChildren().add(node);
                playfield.set(node, i, j);
            }
        }
	}
	
	public void execute(ActionEvent e) {
		int numThreads = (int) Math.round(processesSlider.getValue());
        logger.log("Executing with " + numThreads + " threads.");
        if(numThreads == 0) return;
        
        CustomThreadManager ctm = new CustomThreadManager(threads_table, playfield);
        TaskExecutor te = new TaskExecutor(numThreads);

        long startTime = System.nanoTime();

        var futures = te.submitTasks(playfield);

        for (Future<ThreadResult> future : futures) {
            try {
                ctm.addThreadResult(future.get());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        te.shutdown();

        long totalTime = System.nanoTime() - startTime;
        double timeInSec = totalTime / 1000000000.00;
        logger.log(String.format("Total Execution Time: %.3f seconds%n", timeInSec));
        
        elapsedTime.setText(String.format("%.3fs", timeInSec));
        
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		id.setCellValueFactory(new PropertyValueFactory<CustomThread, Integer>("id"));
		name.setCellValueFactory(new PropertyValueFactory<CustomThread, String>("name"));
		returnedResult.setCellValueFactory(new PropertyValueFactory<CustomThread, String>("returnedResult"));
		timeSpent.setCellValueFactory(new PropertyValueFactory<CustomThread, String>("timeSpent"));
		status.setCellValueFactory(new PropertyValueFactory<CustomThread, String>("status"));
		
	}
}
