import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Нет использования состояния.
        // Определяются не изменяемые final-переменные byEsenin и list.
        final String byEsenin =
                "тот кто видел хоть однажды этот край и эту гладь гладь гладь гладь тот почти берёзке каждой ножку рад поцеловать";
        final List<String> list = Arrays.asList(byEsenin.split(" "));

        // Определяется реализация функционального интерфейса Function.
        // С помощью монад, используя Stream API, функция очищается.
        Function<List<String>, List<String>> myFunction = source -> source.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // Опять цепочка монад.
        // Так же функция высшего порядка. В forEach вызывается println (ссылка на метод).
        // Уточнение. В условии задачи не требуется вывод в консоль. Вывел для наглядности.
        myFunction.apply(list)
                .forEach(System.out::println);
    }
}