package kr.ac.inha.mapper;

import kr.ac.inha.dto.MemberDto;

public interface MemberMapper {
    public void processAddMember(MemberDto dto) throws Exception;
    public MemberDto processLoginMember(String id, String pw)throws Exception;
    public void processUpdateMember(MemberDto dto)throws Exception;

    public void deleteMember(String id) throws Exception;
}
