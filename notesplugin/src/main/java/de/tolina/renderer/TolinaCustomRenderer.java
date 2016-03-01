package de.tolina.renderer;

import com.atlassian.jira.issue.fields.renderer.IssueRenderContext;
import com.atlassian.jira.issue.fields.renderer.JiraRendererPlugin;
import com.atlassian.jira.plugin.renderer.JiraRendererModuleDescriptor;

public class TolinaCustomRenderer implements JiraRendererPlugin{
	
	public static final String TYPE = "tolina-custom-renderer";
	
	private JiraRendererModuleDescriptor jiraRendererModuleDescriptor;
	
	public JiraRendererModuleDescriptor getDescriptor() {
		return jiraRendererModuleDescriptor;
	}

	public String getRendererType() {
		return TYPE;
	}

	public void init(JiraRendererModuleDescriptor arg0) {
		jiraRendererModuleDescriptor = arg0;
		
	}

	public String render(String arg0, IssueRenderContext arg1) {
		return renderTextWithNotesLink(arg0);
	}
	
	private String renderTextWithNotesLink(String s) {
		return s.replaceAll("notes:[^\\s]+", "test").toString();//"[$1|hallo $1]").toString();
	}

	public String renderAsText(String arg0, IssueRenderContext arg1) {
		return arg0;
	}

	public Object transformForEdit(Object arg0) {
		return arg0;
	}

	public Object transformFromEdit(Object arg0) {
		return arg0;
	}

}
