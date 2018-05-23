package org.jboss.netty.buffer;

import java.nio.ByteOrder;

/**
 * A skeletal implementation of {@link ChannelBufferFactory}.
 */
public abstract class AbstractChannelBufferFactory implements ChannelBufferFactory {

    private final ByteOrder defaultOrder;
    
    protected AbstractChannelBufferFactory() {
        this(ByteOrder.BIG_ENDIAN);
    }
    
    protected AbstractChannelBufferFactory(ByteOrder defaultOrder) {
        if (defaultOrder == null) {
            throw new NullPointerException("defaultOrder");
        }
        this.defaultOrder = defaultOrder;
    }

    public ChannelBuffer getBuffer(int capacity) {
        return getBuffer(getDefaultOrder(), capacity);
    }

    public ChannelBuffer getBuffer(byte[] array, int offset, int length) {
        return getBuffer(getDefaultOrder(), array, offset, length);
    }

    public ByteOrder getDefaultOrder() {
        return defaultOrder;
    }
}
