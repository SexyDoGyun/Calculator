package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultRepository<T extends Number> {
    private final List<T> results = new ArrayList<>();

    // 저장
    public void save(T result) {
        results.add(result);
    }

    // 전체 결과 조회
    public List<T> findAll() {
        return new ArrayList<>(results);
    }

    // 가장 오래된 값 삭제
    public void deleteOldest() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    // 특정 값보다 큰 결과 조회
    public List<T> findBigger(double value) {
        return results.stream()
                .filter(result -> result.doubleValue() > value)
                .collect(Collectors.toList());
    }
}
