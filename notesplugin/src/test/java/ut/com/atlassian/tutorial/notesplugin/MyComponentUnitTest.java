package ut.com.atlassian.tutorial.notesplugin;

import org.junit.Test;
import com.atlassian.tutorial.notesplugin.api.MyPluginComponent;
import com.atlassian.tutorial.notesplugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}