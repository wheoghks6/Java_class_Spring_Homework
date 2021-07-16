package kr.ac.inha.service;

import kr.ac.inha.dto.MemberDto;
import kr.ac.inha.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class MemberService {
    @Autowired
    public MemberMapper mapper;

    public void processAddMember(MemberDto dto) throws Exception{
        mapper.processAddMember(dto);
    }
    public MemberDto processLoginMember(String id, String pw)throws Exception{
        return mapper.processLoginMember(id,pw);
    }
    public void processUpdateMember(MemberDto dto)throws Exception{
        mapper.processUpdateMember(dto);
    }
    public void deleteMember(String id) throws Exception
    {
        mapper.deleteMember(id);
    }
}
