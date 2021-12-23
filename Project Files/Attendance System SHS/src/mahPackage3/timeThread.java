package mahPackage3;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class timeThread extends SwingWorker<String, String>{
    private myFunctions my;
    private JLabel textArea;

    public timeThread(JLabel textArea) {
        this.textArea = textArea;
        my = new myFunctions(true);
    }

    @Override
    protected String doInBackground() throws Exception {
        try {
            String result[];
            String timeFull[];
            String dateTime[];
            while (true) {                
                result = my.return_values_silent("now()", "", "",new int[] {0});
                if(result != null){
                    timeFull = result[0].split("@@");
                    dateTime = timeFull[0].split(" ");
                    textArea.setText(my.numberToWordDate(dateTime[0])+" "+dateTime[1]);
                }else{
                    textArea.setText("DISCONNECTED");
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            
        }
        return null;
    }

    @Override
    protected void done() {
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
}
