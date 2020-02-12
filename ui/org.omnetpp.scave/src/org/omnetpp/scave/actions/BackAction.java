package org.omnetpp.scave.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.omnetpp.scave.editors.ChartScriptEditor;
import org.omnetpp.scave.editors.ScaveEditor;

public class BackAction extends AbstractScaveAction {
    public BackAction() {
        setText("Back");
        setImageDescriptor(
                PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_BACK));
    }

    @Override
    protected void doRun(ScaveEditor scaveEditor, ISelection selection) throws CoreException {
        ChartScriptEditor editor = scaveEditor.getActiveChartScriptEditor();
        if (editor != null)
            editor.getMatplotlibChartViewer().back();
    }

    @Override
    protected boolean isApplicable(ScaveEditor scaveEditor, ISelection selection) {
        ChartScriptEditor editor = scaveEditor.getActiveChartScriptEditor();
        return editor != null && editor.isPythonProcessAlive();
    }
}