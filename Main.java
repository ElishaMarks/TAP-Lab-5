import java.util.*;



class NoNegativeNumbersException extends Exception {
    public NoNegativeNumbersException(String message) {
        super(message);
    }
}

class NoPositiveNumbersException extends Exception {
    public NoPositiveNumbersException(String message) {
        super(message);
    }
}

class NoNumbersException extends Exception {
    public NoNumbersException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Introduceți numerele (0 pentru a opri introducerea):");
        int input;
        while ((input = scanner.nextInt()) != 0) {
            numbers.add(input);
        }

        try {
            sortAndThrowException(numbers);
            System.out.println("Lista sortată: " + numbers);
        } catch (Exception e) {
            System.out.println("A fost aruncată o excepție: " + e.getMessage());
        }

        scanner.close();
    }

    public static void sortAndThrowException(List<Integer> numbers) throws  NoNegativeNumbersException, NoPositiveNumbersException, NoNumbersException {
        if (numbers.isEmpty()) {
            throw new NoNumbersException("Lista este goală!");
        }

        boolean hasNegative = false;
        boolean hasPositive = false;

        for (int num : numbers) {
            if (num < 0) {
                hasNegative = true;
            } else if (num > 0) {
                hasPositive = true;
            }
        }

        if (!hasNegative) {
            throw new NoNegativeNumbersException("Nu există numere negative în listă!");
        }

        if (!hasPositive) {
            throw new NoPositiveNumbersException("Nu există numere pozitive în listă!");
        }

        if (hasNegative && hasPositive) {
            Collections.sort(numbers, (a, b) -> {
                if (a >= 0 && b < 0) {
                    return -1;
                } else if (a < 0 && b >= 0) {
                    return 1;
                } else {
                    return a.compareTo(b);
                }
            });

        } else {
            Collections.sort(numbers);
        }
    }
}
