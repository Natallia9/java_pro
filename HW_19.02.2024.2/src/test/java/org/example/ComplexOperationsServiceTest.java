package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ComplexOperationsServiceTest {
    private final ComplexOperationsService service = new ComplexOperationsService();

    @ParameterizedTest
    @CsvSource({
            "weak, false",
            "strongPassword1@, true",
            "noDigit!, false",
            "NoSpecialChar1, false"
    })
    void validatePasswordStrength(String password, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
        } else {
            assertDoesNotThrow(() -> service.validatePasswordStrength(password));
        }
        // Assume no exception for valid passwords
        // This is a placeholder for actual validation logic if method returns a value or has other effects

    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    void processText(String text) {
        if (text.contains("error") || text.contains("fail") || text.contains("wrong")) {
            assertThrows(IllegalArgumentException.class, () -> service.processText(text));
        } else {
            assertDoesNotThrow(() -> service.processText(text));
            // Assume no exception for valid texts
        }
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "one,two,three", "10,,20", "5.5,6.5"})
    void sumOfNumbersInString(String numbers) {
        if (numbers.matches(".*[a-zA-Z]+.*") || numbers.contains(",,")) {
            assertThrows(IllegalArgumentException.class, () -> service.sumOfNumbersInString(numbers));
        } else {
            assertDoesNotThrow(() -> service.sumOfNumbersInString(numbers));
            // Assume no exception for valid number strings
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://valid.com", "https://valid.com", "ftp://invalid.com", "justtext"})
    void validateUrlFormat(String url) {
        if (!url.startsWith("http")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateUrlFormat(url));
        } else {
            assertDoesNotThrow(() -> service.validateUrlFormat(url));
            // Assume no exception for valid URLs
        }
    }

    public static Stream<Arguments> emailListProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("valid@email.com", "invalid-email"), false),
                Arguments.of(Arrays.asList("valid@email.com", "also.valid@email.com"), true)
        );
    }

    @ParameterizedTest
    @MethodSource("emailListProvider")
    void checkEmailListConsistency(List<String> emails, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(emails));

        } else {
            assertDoesNotThrow(() -> service.checkEmailListConsistency(emails));

        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"table", "chair", "anna"})
    void checkStringPalindrome(String input) {
        if (!input.equals(new StringBuilder(input).reverse().toString())) {
            assertThrows(IllegalArgumentException.class, () -> service.checkStringPalindrome(input));
        } else {
            assertDoesNotThrow(() -> service.checkStringPalindrome(input));
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"AB123456", "KH3456987", "K34569"})
    void validateIdentificationNumber(String id){
        if (!id.matches("^[A-Za-z]{2}\\d{6}$")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateIdentificationNumber(id));
        } else {
            assertDoesNotThrow(() -> service.validateIdentificationNumber(id));
        }
    }
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 5, true),
                Arguments.of(Arrays.asList(1, 2, 3), 6, false)
        );
    }
    @ParameterizedTest
    @MethodSource("dataProvider")
    void checkSumOfListAgainstThreshold(List<Integer> numbers, int threshold, boolean isValid){
        if (!isValid){
            assertThrows(IllegalArgumentException.class, () -> service.checkSumOfListAgainstThreshold(numbers, threshold));
        } else {
            assertDoesNotThrow(() -> service.checkSumOfListAgainstThreshold(numbers, threshold));
        }
    }
    @ParameterizedTest
    @ValueSource(strings = {"10.0.0.255", "12.0.34", "172.16.254.123"})
    void validateIPAddress(String ipAddress){
        if(!ipAddress.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")){
            assertThrows(IllegalArgumentException.class, () -> service.validateIPAddress(ipAddress));
        } else {
            assertDoesNotThrow(() -> service.validateIPAddress(ipAddress));
        }
    }
    static Stream<Arguments> duplicateProvider(){
        return Stream.of(
                Arguments.of(List.of("hello", "world", "hello"), false), // ожидается исключение, так как есть дубликаты
                Arguments.of(List.of("duplicate", "elements", "in", "a", "list"), true) // ожидается успешное выполнение, нет дубликатов
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateProvider")
    void ensureNoDuplicateEntries(List<String> entries, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.ensureNoDuplicateEntries(entries));
        } else {
            assertDoesNotThrow(() -> service.ensureNoDuplicateEntries(entries));
        }
    }
}

