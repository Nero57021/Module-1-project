package Sherpa.Module;

import Sherpa.Module.Services.Consumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

class ModuleApplicationTests {
	@Autowired
	Consumer consumer = new Consumer();
	@Test
	public void emptyLine() {
		String demo = "";
		assertTrue(demo.isEmpty());

	}
	@Test
	public void incorrectFormat() {
		assertThat(consumer.parser("12,invalid form"), equalTo("Message should be complete in format of: (SERVER_ID, CPU_UTILIZATION, MEMORY_UTILIZATION, DISK_UTILIZATION)"));
	}

	@Test
	public void testNoAlert() {
		assertThat(consumer.parser("12,24,34,36"), equalTo("(No alert,12)"));
	}
	@Test
	public void testCPUViolation() {
		assertThat(consumer.parser("12,85,34,36"), equalTo("(12, CPU_UTILIZATION)"));
	}
	@Test
	public void testMEMViolation() {
		assertThat(consumer.parser("12,79,76,36"), equalTo("(12, MEMORY_UTILIZATION)"));
	}
	@Test
	public void testDISKViolation() {
		assertThat(consumer.parser("12,79,34,90"), equalTo("(12, DISK_UTILIZATION)"));
	}
	@Test
	public void testCPUandMEMViolation() {
		assertThat(consumer.parser("12,85,76,36"), equalTo("(12, CPU_UTILIZATION, MEMORY_UTILIZATION)"));
	}
	@Test
	public void testCPUandDISKViolation() {
		assertThat(consumer.parser("12,85,72,65"), equalTo("(12, CPU_UTILIZATION, DISK_UTILIZATION)"));
	}
	@Test
	public void testMEMORYandDISKViolation() {
		assertThat(consumer.parser("12,37,77,65"), equalTo("(12, MEMORY_UTILIZATION, DISK_UTILIZATION)"));
	}
	@Test
	public void CPU_MEM_DISK_Violation() {
		assertThat(consumer.parser("12,85,78,65"), equalTo("(12, CPU_UTILIZATION, MEMORY_UTILIZATION, DISK_UTILIZATION)"));
	}
}

