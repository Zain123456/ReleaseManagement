import { TestBed } from '@angular/core/testing';

import { ReleasemanagementService } from './releasemanagement.service';

describe('ReleasemanagementService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReleasemanagementService = TestBed.get(ReleasemanagementService);
    expect(service).toBeTruthy();
  });
});
