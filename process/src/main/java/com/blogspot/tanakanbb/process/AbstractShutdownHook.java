/**
 * 
 */
package com.blogspot.tanakanbb.process;

/**
 * @author nobutnk
 *
 */
public abstract class AbstractShutdownHook implements ShutdownHook {

    /* (non-Javadoc)
     * @see com.blogspot.tanakanbb.process.ShutdownHook#execute()
     */
    public void execute() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                release();
            }
        });
        doExecute();
    }

    /**
     * リソースの解放処理
     */
    public abstract void release();
    
    /**
     * メイン処理
     */
    public abstract void doExecute();
}
