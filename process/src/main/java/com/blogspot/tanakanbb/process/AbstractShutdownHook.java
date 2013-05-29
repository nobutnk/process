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
     * ���\�[�X�̉������
     */
    public abstract void release();
    
    /**
     * ���C������
     */
    public abstract void doExecute();
}
