class Solution:
    def removeDuplicates(self, nums) -> int:
        if len(nums) < 1:
            return 0
        elif len(nums) == 1:
            return 1
        else:
            current = nums[0]
            index = 1
            current_index = 1
            while current_index < len(nums):
                if nums[current_index] == current:
                    current_index += 1
                else:
                    current = nums[current_index]
                    nums[index] = nums[current_index]
                    index += 1
                    current_index += 1
            return index