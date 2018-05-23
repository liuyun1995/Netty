package org.jboss.netty.channel;

/**
 * ChannelFutureListener implementation which takes another ChannelFuture and notifies it
 * once the operationComplete method was called.
 */
public final class ChannelFutureNotifier implements ChannelFutureListener {
    
	private final ChannelFuture future;

    public ChannelFutureNotifier(ChannelFuture future) {
        this.future = future;
    }

    public void operationComplete(ChannelFuture cf) throws Exception {
        if (cf.isSuccess()) {
            future.setSuccess();
        } else {
            future.setFailure(cf.getCause());
        }
    }
    
}
