package com.money.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:beans.xml"})
public class OriginalNumberRepositoryTest
{
  @Autowired
  private OriginalNumberRepository originalNumberRepository;
  
  @Test
  public void query()
  {
    long iter = this.originalNumberRepository.count();
    System.out.println(iter);
    System.out.println(this.originalNumberRepository.findById(Long.valueOf(1L)));
  }
}
