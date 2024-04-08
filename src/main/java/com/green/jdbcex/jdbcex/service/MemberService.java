package com.green.jdbcex.jdbcex.service;

import com.green.jdbcex.jdbcex.dao.MemberDAO;
import com.green.jdbcex.jdbcex.domain.MemberVO;
import com.green.jdbcex.jdbcex.dto.MemberDTO;
import com.green.jdbcex.jdbcex.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        this.dao = new MemberDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();

    }

    // ID, PW로 로그인
    public MemberDTO login(String mid, String mpw){
        MemberVO vo = null;
        try {
            vo = dao.getWithPassword(mid, mpw);

        } catch (Exception e) {
            log.info("로그인 시 예외발생");
//            throw new RuntimeException(e);
        }

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);
        return memberDTO;
    }

    // UUID 데이터 추가
    public void updateUuid(String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
    }

    // UUID로 memberVO 조회
    public MemberDTO getByUUid(String uuid) throws Exception {
        MemberVO vo = dao.selectUuid(uuid);
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);
        return memberDTO;
    }

}
