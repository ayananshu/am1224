package test;

import main.Tool;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class ToolTest {
    @Test
    void testToolCreation() {
        Tool tool = new Tool("LADW", Tool.ToolType.LADDER, "Werner");
        assertEquals("LADW", tool.getToolCode());
        assertEquals(Tool.ToolType.LADDER, tool.getType());
        assertEquals("Werner", tool.getBrand());
    }

}