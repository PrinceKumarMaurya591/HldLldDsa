package com.conceptcoding.video1solid.dependencyinversion.violation;

import com.codebytes.video1.dependencyinversion.utility.Keyboard;
import com.codebytes.video1.dependencyinversion.utility.Mouse;
import com.codebytes.video1.dependencyinversion.utility.WiredKeyboard;
import com.codebytes.video1.dependencyinversion.utility.WiredMouse;

// VIOLATION OF DIP
// High-level module directly depending on low-level module
public class MacBook {
    private final WiredKeyboard keyboard;
    private final WiredMouse mouse;

    // Direct dependency on concrete class
    public MacBook(WiredKeyboard wiredKeyboard, WiredMouse wiredMouse) {
        keyboard = wiredKeyboard; // Tight coupling
        mouse = wiredMouse; // Tight coupling
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }
}