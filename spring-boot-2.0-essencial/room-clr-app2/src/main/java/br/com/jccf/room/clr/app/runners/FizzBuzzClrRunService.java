package br.com.jccf.room.clr.app.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class FizzBuzzClrRunService implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("FizzBuzz test start");

        for (int i = 0; i < 10; i++) {
            String result = ((i % 3 == 0) ? "Fizz" : "") +
                    ((i % 5 == 0) ? "Buzz" : "");

            System.out.println(result.isEmpty() ? i : result);
        }

        System.out.println("FizzBuzz test finish");
    }
}
