/*
 * TabTitle.java
 * Copyright 2010 Connor Petty <cpmeister@users.sourceforge.net>
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 * Created on Aug 3, 2010, 5:36:10 PM
 */
package pcgen.gui2.tabs;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Hashtable;

import pcgen.system.LanguageBundle;

/**
 *
 * @author Connor Petty <cpmeister@users.sourceforge.net>
 */
public class TabTitle
{

	public static final String FOREGROUND = "foreground";
	public static final String BACKGROUND = "background";
	public static final String ENABLED = "enabled";
	public static final String TITLE = "title";
	public static final String ICON = "icon";
	public static final String TOOLTIP = "tooltip";
	private PropertyChangeSupport support;
	private Hashtable<String, Object> table;

	public TabTitle(String title)
	{
		this();
		if (title.startsWith("in_"))
		{
			putValue(TITLE, LanguageBundle.getString(title));
		}
		else
		{
			putValue(TITLE, title);
		}
	}

	public TabTitle()
	{
		support = new PropertyChangeSupport(this);
		table = new Hashtable<String, Object>();
	}

	public void addPropertyChangeListener(PropertyChangeListener l)
	{
		support.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l)
	{
		support.removePropertyChangeListener(l);
	}

	public Object getValue(String prop)
	{
		return table.get(prop);
	}

	public void putValue(String prop, Object value)
	{
		support.firePropertyChange(prop, table.put(prop, value), value);
	}

	public void setEnabled(boolean enable)
	{
		putValue(ENABLED, enable);
	}

	public boolean isEnabled()
	{
		return (Boolean) getValue(ENABLED);
	}

}
