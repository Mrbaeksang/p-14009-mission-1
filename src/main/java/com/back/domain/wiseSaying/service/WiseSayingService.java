package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    private final WiseSayingRepository repository;

    public WiseSayingService() {
        this.repository = new WiseSayingRepository();
    }

    public WiseSaying register(String content, String author) {
        int lastId = repository.getLastId();
        int id = (lastId == 0) ? 1 : lastId + 1;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        repository.save(wiseSaying);
        repository.saveLastId(id);

        return wiseSaying;
        }

        // TODO: 마지막 ID 가져오기 → 다음 ID 계산

        // TODO: 새 WiseSaying 객체 생성
        // TODO: Repository에 저장
        // TODO: 저장한 객체 리턴

    }

    public List<WiseSaying> findAll() {
        // TODO: Repository에서 전체 명언 목록 가져오기
        return null;
    }

    public WiseSaying findById(int id) {
        // TODO: Repository에서 해당 ID에 맞는 명언 조회
        return null;
    }

    public void remove(int id) {
        // TODO: Repository에서 해당 ID 삭제
    }

    public void modify(int id, String content, String author) {
        // TODO: Repository에서 해당 ID의 명언 수정
    }
}
