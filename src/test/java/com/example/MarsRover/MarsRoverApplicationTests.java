package com.example.MarsRover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MarsRoverApplicationTests {

	MarsRover marsRover;

	@BeforeEach
	void set() {
		marsRover = new MarsRover();
	}

	@Test
	void stay_in_the_initial_position_if_no_commands_passed() {
		assertEquals("0:0:N", marsRover.execute(""));
	}

	@Test
	void move_forward() {
		assertEquals("0:1:N", marsRover.execute("M"));
	}

	@Test
	void move_forward_twice() {
		assertEquals("0:2:N", marsRover.execute("MM"));
	}

	@ParameterizedTest
	@CsvSource({"M, 0:1:N","MM, 0:2:N","MMM, 0:3:N"})
	void move_forward(String commands, String expectedPosition) {
		assertEquals(expectedPosition, marsRover.execute(commands));
	}

	@ParameterizedTest
	@CsvSource({"MMMMMMMMMM, 0:0:N","MMMMMMMMMMM, 0:1:N","LM, 9:0:W","RRM, 0:9:S"})
	void wrap_around_at_the_edge(String commands, String expectedPosition) {
		assertEquals(expectedPosition, marsRover.execute(commands));
	}

	@ParameterizedTest
	@CsvSource({"R, 0:0:E","RR, 0:0:S", "RRR, 0:0:W", "RRRR, 0:0:N"})
	void rotate_right(String commands, String expectedPosition) {
		assertEquals(expectedPosition, marsRover.execute(commands));
	}

	@ParameterizedTest
	@CsvSource({"L, 0:0:W","LL, 0:0:S", "LLL, 0:0:E", "LLLL, 0:0:N"})
	void rotate_left(String commands, String expectedPosition) {
		assertEquals(expectedPosition, marsRover.execute(commands));
	}

	@ParameterizedTest
	@CsvSource({"RM, 1:0:E", "RMMMMMMMMMM, 0:0:E"})
	void move_right(String commands, String expectedPosition) {
		assertEquals(expectedPosition, marsRover.execute(commands));
	}

	@Test
	void report_found_obstacle() {
		assertEquals("O:0:1:E",marsRover.execute("MRM"));
	}
}
