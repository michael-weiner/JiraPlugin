package de.tolina.renderer;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.jira.config.properties.ApplicationProperties;
import com.atlassian.jira.issue.fields.renderer.IssueRenderContext;
import com.atlassian.jira.issue.fields.renderer.wiki.AtlassianWikiRenderer;
import com.atlassian.jira.plugin.renderer.JiraRendererModuleDescriptor;
import com.atlassian.jira.util.velocity.VelocityRequestContextFactory;

public class NotesLinkRenderer extends AtlassianWikiRenderer{
	
	public static final String TYPE = "tolina-custom-renderer";
	private JiraRendererModuleDescriptor jiraRendererModuleDescriptor;
	
	public NotesLinkRenderer(EventPublisher eventPublisher,
			ApplicationProperties applicationProperties,
			VelocityRequestContextFactory velocityRequestContextFactory) {
		super(eventPublisher, applicationProperties, velocityRequestContextFactory);
	}
	
	public JiraRendererModuleDescriptor getDesriptor(){
		return jiraRendererModuleDescriptor;
	}

	public String getRendererType(){
		return TYPE;
	}
	
	public void init(JiraRendererModuleDescriptor jiraRendererModuleDescriptor) {
		this.jiraRendererModuleDescriptor = jiraRendererModuleDescriptor;
	}
	
	public String render(String s, IssueRenderContext issueRenderContext){
		String replacedResult = renderTextWithNotesLink(s);
		return super.render(replacedResult, issueRenderContext);
	}

	private String renderTextWithNotesLink(String s) {
		return s.replaceAll("notes:[^\\s]+", "[$1|hallo $1]").toString();
	}
	
	public String renderAsText(String s, IssueRenderContext issueRenderContext) {
		return s;
	}
	
	public Object transformForEdit(Object obj) {
		return obj;
	}
	
	public Object transformFromEdit(Object obj) {
		return obj;	
	}
}
