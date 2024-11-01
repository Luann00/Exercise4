package qm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * SPDX-FileCopyrightText: 2024 Jane Doe <jane@example.com>
 *
 * SPDX-License-Identifier: MIT
 */


import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @Test
    void testEmptyWhenArrayIsEmpty() {
        stack = new Stack(0);
        assertTrue(stack.isEmpty());
    }

    @Test
    void testEmptyWhenArrayIsNotEmpty() {
        stack = new Stack(1);
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPopWithAnEmptyStack() {
        stack = new Stack(1);
        assertEquals(-1, stack.pop()); //if there is an empty stack, it should return -1
    }

    @Test
    void testPopWithElementsInStack() {
        stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop()); //should return 3, because 3 is now the last element
        assertEquals(2, stack.pop()); //should return 2, because 2 is now the last element
        assertEquals(1, stack.pop()); //should return 1, because 1 is now the last element
    }

    @Test
    void testPushWithException() {
        stack = new Stack(2);

        //adding negative numbers should throw exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.push(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.push(-5));
    }

    @Test
    void testPushWhenAnArrayIsAlreadyFull() {
        stack = new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        StackOverflowError exception = assertThrows(StackOverflowError.class, () -> {
            stack.push(4);
        });

        //test whether an Exception Message gets thrown
        assertEquals("Stack is full", exception.getMessage());
    }

    @Test
    void testPushNormal() {
        stack = new Stack(3);
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    void testSizeWithAnEmptyArray() {
        //check empty size
        stack = new Stack(1);
        assertEquals(0, stack.size());
    }

    @Test
    void testSizeWithANonEmptyArray() {
        stack = new Stack(3);

        //push one element and check
        stack.push(1);
        assertEquals(1, stack.size());

        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    void testTopWithAnEmptyArray() {
        stack = new Stack(5);
        assertEquals(-1, stack.top());
    }


    @Test
    void testTopWithANonEmptyArray() {
        stack = new Stack(3);

        //add 3 elements and see if the last element (3) gets returned
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.top());
    }
}