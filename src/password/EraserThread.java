package password;

/**
 * Copied from http://stackoverflow.com/questions/10819469/hide-input-on-command-line.
 */

public class EraserThread implements Runnable {
    private final String prompt;
    private boolean stop;

    /**
     *@param prompt displayed to the user
     */
    public EraserThread(String prompt) {
        this.prompt = prompt;
        System.out.println(prompt);
    }

    /**
     * Begin masking...display asterisks (*)
     */
    public void run () {
        stop = true;
        while (stop) {
            System.out.println(prompt);
            try {
                Thread.currentThread().sleep(10);
            } catch(InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    /**
     * Instruct the thread to stop masking
     */
    public void stopMasking() {
        this.stop = false;
    }
}
