package com.sun.media.controls;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.media.control.BitRateControl;

import com.sun.media.ui.TextComp;

/**
 * TODO: Stub
 * @author Ken Larson
 *
 */
public class BitRateAdapter implements BitRateControl, ActionListener
{
	protected int min;
	protected int max;
	protected int value;
	protected boolean settable;
	protected final TextComp textComp;
	public BitRateAdapter(int value, int min, int max, boolean settable)
	{
		super();
		this.value = value;
		this.min = min;
		this.max = max;
		this.settable = settable;
		this.textComp = new TextComp();		// TODO - implement this class
	}
	public Component getControlComponent()
	{
		throw new UnsupportedOperationException(); // TODO
	}
	public void actionPerformed(ActionEvent e)
	{
		throw new UnsupportedOperationException(); // TODO
	}
	public int getBitRate()
	{
		return value;
	}
	public int getMaxSupportedBitRate()
	{
		return max;
	}
	public int getMinSupportedBitRate()
	{
		return min;
	}
	public int setBitRate(int bitrate)
	{
		throw new UnsupportedOperationException(); // TODO
	}
	
}
