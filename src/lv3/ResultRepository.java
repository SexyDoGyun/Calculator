package lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 연산 결과를 저장하고 관리하는 저장소 클래스
 * 제네릭 타입 T는 Number를 상속받는 타입만 사용 가능
 */
public class ResultRepository {

    //계산 결과 저장 리스트
    private final List<Double> results = new ArrayList<>();

    // 저장
    public void save(double result) {
        results.add(result);
    }

    // 전체 결과 조회
    public List<Double> findAll() {
        return new ArrayList<>(results);
    }

    // 가장 오래된 값 삭제
    public void deleteOldest() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    // 특정 값보다 큰 결과 조회
    public List<Double> findBigger(double value) {
        return results.stream()
                .filter(result -> result > value)
                .collect(Collectors.toList());
    }
}
