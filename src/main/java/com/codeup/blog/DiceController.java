package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String diceGame() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String playDiceGame(@PathVariable int n, Model viewModel) {
        int dieRoll = (int) ((Math.random() * 6) + 1);
        viewModel.addAttribute("num", n);
        viewModel.addAttribute("die", dieRoll);
        return "roll-dice";
    }


}
