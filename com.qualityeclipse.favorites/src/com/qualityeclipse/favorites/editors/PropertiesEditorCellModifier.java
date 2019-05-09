package com.qualityeclipse.favorites.editors;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TreeViewer;

public class PropertiesEditorCellModifier implements ICellModifier
{

	private PropertiesEditor editor;
	
	public PropertiesEditorCellModifier(PropertiesEditor editor, TreeViewer viewer)
	{
		this.editor = editor;
	}

	@Override
	public boolean canModify(Object element, String property)
	{
		if(property == PropertiesEditor.KEY_COLUMN_ID)
		{
			if(element instanceof PropertyCategory)
				return true;
			if(element instanceof PropertyEntry)
				return true;
		}
		
		if(property == PropertiesEditor.VALUE_COLUMN_ID)
		{
			if(element instanceof PropertyEntry)
				return true;
		}
		return false;
	}

	@Override
	public Object getValue(Object element, String property)
	{
		if(property == PropertiesEditor.KEY_COLUMN_ID)
		{
			if(element instanceof PropertyCategory)
				return ((PropertyCategory)element).getName();
			if(element instanceof PropertyEntry)
				return ((PropertyEntry)element).getKey();
		}
		return null;
	}

	@Override
	public void modify(Object element, String property, Object value)
	{
	}

}
